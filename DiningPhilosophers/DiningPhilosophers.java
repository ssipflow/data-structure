
public class DiningPhilosophers {
	//각 "포크"는 그냥 Object 객체로 정의하고 포크에 대해 동기화시킨다.
	private Object[] forks;
	private Philosopher[] philosophers;
	//포크와 철학자들을 준비한다.
	private DiningPhilosophers(int num){
		forks = new Object[num];
		philosophers = new Philosopher[num];
		for(int i = 0; i < num; i++){
			forks[i] = new Object();
			int fork1 = i;
			int fork2 = (i+1)%num;
			if(i == 0){
				philosophers[i] = new Philosopher(i, fork2, fork1);
			}else{
				philosophers[i] = new Philosopher(i, fork1, fork2);
			}
		}
	}
	//먹기시작
	public void startEating() throws InterruptedException{
		for(int i = 0; i < philosophers.length; ++i){
			philosophers[i].start();
		}
		/* 첫 번쨰 철학자가 먹는 것을 중단할 때까지 스레드를
		 * 중단시킨다. 하지만 첫 번째 철학자가 먹는 것을 중단하는
		 * 일이 일어나지 않으므로 시뮬레이션이 무한정 돌아간다. 
		 */
		philosophers[0].join();
	}
	
	//각 철학자는 서로 다른 스레드에서 돌아감
	private class Philosopher extends Thread{
		private int id;
		private int fork1;
		private int fork2;
		
		Philosopher(int id, int fork1, int fork2){
			this.id = id;
			this.fork1 = fork1;
			this.fork2 = fork2;
		}
		
		public void run(){
			status("Ready to eat using forks " + fork1 + "and " + fork2);
			while(true){
				status("Picking up fork " + fork1);
				synchronized(forks[fork1]){
					status("Picking up for " + fork2);
					synchronized(forks[fork2]){
						status("Eating");
					}
				}
			}
		}
		
		private void status(String msg){
			System.out.println("Philosopher " + id + ": " + msg);
		}
	}
	
	public static void main(String[] args){
		try{
			DiningPhilosophers d = new DiningPhilosophers(5);
			d.startEating();
		}
		catch(InterruptedException e){
			
		}
	}
}
