package CONTROLLER;

import java.util.ArrayList;
import MODEL.BgmVO;
import javazoom.jl.player.MP3Player;

public class BgmController {
	
	ArrayList<BgmVO> bgmList = new ArrayList<BgmVO>(3);
	MP3Player mp3 = new MP3Player();
	
	public void bgmList() {
		bgmList.add(new BgmVO("startBGM", "bgm/startBGM.mp3"));
		bgmList.add(new BgmVO("endingBGM", "bgm/endingBGM.mp3"));
	}
	
	public void startBgmPlay() {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(bgmList.get(0).getSongPath());
	}
	
	public void endBgmPlay() {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(bgmList.get(1).getSongPath());
	}
	
	public void playingBgmPlay() {
		if(mp3.isPlaying()) {
			mp3.stop();
		}
		mp3.play(bgmList.get(2).getSongPath());
	}
	
	public void stop() {
		mp3.stop();
	}
	
//	public void next() {
//		if(mp3.isPlaying()){
//			mp3.stop();
//		}
//		if(index < bgmList.size() - 1) {
//			index++;
//			
//		}else {
//			index = 0;
//		}
//		mp3.play(bgmList.get(index).getSongPath());
//	}
//	
//	public void pre() {
//		if(mp3.isPlaying()){
//			mp3.stop();
//		}
//		if(index > 0) {
//			index--;
//		}else {
//			index = bgmList.size()-1;
//		}
//		mp3.play(bgmList.get(index).getSongPath());
//	}
	


}
