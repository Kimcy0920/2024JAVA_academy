package java0729;

public class ThreadA extends Thread {
	public ThreadA() {
		setName("ThreadA");
	}
	
	public void run() {
		for(int i=0; i<2; i++) {
			System.out.println(this.getName() + "가 출력한 내용");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
