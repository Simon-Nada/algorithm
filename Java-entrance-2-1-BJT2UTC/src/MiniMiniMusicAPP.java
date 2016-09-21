
import javax.sound.midi.*;

public class MiniMiniMusicAPP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MiniMiniMusicAPP mini =new MiniMiniMusicAPP();
		mini.play();
	}
	
	public void play(){
		try {
			Sequencer player = MidiSystem.getSequencer();
			Sequence seq = new Sequence(Sequence.PPQ,4);
			Track track = seq.createTrack();
			
			ShortMessage a = new ShortMessage();
			a.setMessage(144,1,44,100);
			MidiEvent noteOn = new MidiEvent(a,1);
			track.add(noteOn);
			
			ShortMessage b = new ShortMessage();
			b.setMessage(128,1,44,100);
			MidiEvent noteoff = new MidiEvent(b,16);
			track.add(noteoff);
			
			player.setSequence(seq);
			player.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
