package MODEL;

public class BgmVO {

	
	private String songName;
//	private String singer;
//	private int playTime;
	private String songPath;
	
	public BgmVO(String songName, String songPath) {
		this.songName = songName;
//		this.singer = singer;
//		this.playTime = playTime;
		this.songPath = songPath;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

//	public String getSinger() {
//		return singer;
//	}
//
//	public void setSinger(String singer) {
//		this.singer = singer;
//	}
//
//	public int getPlayTime() {
//		return playTime;
//	}
//
//	public void setPlayTime(int playTime) {
//		this.playTime = playTime;
//	}

	public String getSongPath() {
		return songPath;
	}

	public void setSongPath(String songPath) {
		this.songPath = songPath;
	}

	


}
