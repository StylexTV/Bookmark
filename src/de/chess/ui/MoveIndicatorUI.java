package de.chess.ui;

import java.awt.Graphics2D;

import de.chess.game.Board;
import de.chess.game.Move;
import de.chess.game.PieceCode;
import de.chess.main.Constants;
import de.chess.util.ImageUtil;

public class MoveIndicatorUI {
	
	public static void drawMoves(Graphics2D graphics, Board b) {
		if(BoardUI.getSelectedPiece() != -1) {
			int ox = 66;
			int oy = 66;
			
			int previous = -1;
			
			int tileSize = Constants.TILE_SIZE;
			
			graphics.setColor(Constants.COLOR_BOARD_MARKER);
			
			for(Move m : BoardUI.getSelectedMoves()) {
				int to = m.getTo();
				
				if(previous == to) continue;
				
				previous = to;
				
				boolean isAttack = b.getPiece(to) != -1;
				
				if(BoardUI.getHumanSide() == PieceCode.BLACK) {
					to = 63 - to;
				}
				
				int toY = to / 8;
				int toX = to % 8;
				
				if(isAttack) {
					graphics.drawImage(ImageUtil.ATTACK_INDICATOR, ox + toX * tileSize, oy + toY * tileSize, null);
				} else {
					graphics.fillArc(ox + toX * tileSize + tileSize / 2 - 12, oy + toY * tileSize + tileSize / 2 - 12, 24, 24, 0, 360);
				}
			}
		}
	}
	
}
