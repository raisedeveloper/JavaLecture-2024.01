package ch12_interface.sec02_interface;

public class Television implements RemoteControllable {
	private int volume;
	
	@Override
	public void turnOn() {
		System.out.println();
	}

	@Override
	public void turnOff() {
		System.out.println("SmartTV를 켭니다");
	}

	@Override
	public void setVolume(int volume) {
		if (volume > RemoteControllable.MAX_VOLUME)
			this.volume = MAX_VOLUME;
		else if (volume < RemoteControllable.MIN_VOLUME)
			this.volume = MIN_VOLUME;
		else
			this.volume = volume;
		
		System.out.println("현재 TV 볼륨: " + this.volume);
	}

}
