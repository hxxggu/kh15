package api.lang.object;

import java.util.Objects;

public class Student /*extends */{
//내가 만든 클래스는 상속을 적어야 이루어지는데
//Object를 상속받을 수 있는가
		private String name;
		private int score;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getScore() {
			return score;
		}
		public void setScore(int score) {
			this.score = score;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(name, score);
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Student other = (Student) obj;
			return Objects.equals(name, other.name) && score == other.score;
		}
		
		@Override
		public String toString() {
			return "Student [name=" + name + ", score=" + score + "]";
		}
		
		
}
