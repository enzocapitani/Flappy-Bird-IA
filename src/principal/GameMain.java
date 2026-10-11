package principal;

import scenes.DefaultMap;

public class GameMain {
	public static void main(String[] args) {
		GameWindow window = new GameWindow();
		
		window.showWindow(new DefaultMap());
		
	}
}
