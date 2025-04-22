package com.kh.spring12.restcontroller.websocket;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.spring12.dao.RoomDao;
import com.kh.spring12.dto.RoomDto;
import com.kh.spring12.error.TargetNotFoundException;
import com.kh.spring12.service.TokenService;
import com.kh.spring12.vo.ClaimVO;
import com.kh.spring12.vo.websocket.UserVO;

@CrossOrigin
@RestController
@RequestMapping("/api/room")
public class RoomRestController {
	
	@Autowired
	private RoomDao roomDao;
	@Autowired
	private TokenService tokenService;
	
	@PostMapping("/")
	public void create(@RequestBody RoomDto roomDto,
			@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		roomDto.setRoomOwner(claimVO.getUserId()); // 소유자 설정
		roomDao.insert(roomDto);
	}
	
	@GetMapping("/")
	public List<RoomDto> list() {
		return roomDao.selectList();
	}
	
	@GetMapping("/{roomNo}")
	public RoomDto find(@PathVariable long roomNo) {
		RoomDto roomDto = roomDao.selectOne(roomNo);
		if(roomDto == null) {
			throw new TargetNotFoundException("방 번호가 존재하지 않습니다");
		}
		return roomDto;
	}
	
	@DeleteMapping("/{roomNo}")
	public void delete(@PathVariable long roomNo,
			@RequestHeader("Authorization") String bearerToken) {
		// roomDao.delete(roomNo); // 데이터가 없어도 성공하는 문제 발생
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		RoomDto roomDto = roomDao.selectOne(roomNo);
		if(roomDto == null) {
			throw new TargetNotFoundException("방 번호가 존재하지 않습니다");
		}
		if(roomDto.getRoomOwner().equals(claimVO.getUserId()) == false) {
			throw new TargetNotFoundException("방장이 아니면 삭제할 수 없습니다");
		}
		roomDao.delete(roomNo);
	}
	
	@PostMapping("/enter/{roomNo}")
	public void enter(@RequestHeader("Authorization") String bearerToken,
			@PathVariable long roomNo) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		// insert into room_user(room_no, account__id) values(?, ?)
		boolean isEnter = roomDao.checkRoom(roomNo, claimVO.getUserId());
		if(isEnter == false) { // 방에 참여한 적이 없으면
			roomDao.enterRoom(roomNo, claimVO.getUserId());
		}
	}
	
	@GetMapping("/check/{roomNo}")
	public boolean check(@PathVariable long roomNo,
			@RequestHeader("Authorization") String bearerToken) {
		
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken); // 방에 있었는지 아닌지의 유무 + 참여자인지 알려줌
		return roomDao.checkRoom(roomNo, claimVO.getUserId());
	}
	
	@GetMapping("/users/{roomNo}") // 단체 채팅에서 입장하는 회원 권한 조회
	public List<UserVO> users(@PathVariable long roomNo,
			@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		boolean isEnter = roomDao.checkRoom(roomNo, claimVO.getUserId());
		if(isEnter == false) throw new TargetNotFoundException();
		return roomDao.getUsers(roomNo);
	}
	
	@DeleteMapping("/leave/{roomNo}")
	public void leave(@PathVariable long roomNo,
			@RequestHeader("Authorization") String bearerToken) {
		ClaimVO claimVO = tokenService.parseBearerToken(bearerToken);
		boolean isEnter = roomDao.checkRoom(roomNo, claimVO.getUserId());
		if(isEnter == false) throw new TargetNotFoundException();
		roomDao.leaveRoom(roomNo, claimVO.getUserId());
	}
	
}
