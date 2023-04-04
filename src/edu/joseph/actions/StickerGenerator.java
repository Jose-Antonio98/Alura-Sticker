package edu.joseph.actions;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextLayout;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerGenerator {
	
	public void generate(InputStream inputStream, String fileName, String text) {
		
		try {
			var directory = new File("sticker/");
			directory.mkdir();
			
			BufferedImage originalImage = ImageIO.read(inputStream);
		
			int width = originalImage.getWidth();
	        int height = originalImage.getHeight();
	        int newHeight = height + 200;
	        BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);
		
	        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
	        graphics.drawImage(originalImage, 0, 0, null);

	        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 100);
	        graphics.setColor(Color.YELLOW);
	        graphics.setFont(fonte);
	        
	        FontMetrics fontMatrics = graphics.getFontMetrics();
	        Rectangle2D rectangle = fontMatrics.getStringBounds(text, graphics);
	        int widthText = (int) rectangle.getWidth();
	        int positionTextX = (width - widthText) / 2;
	        int positionTextY = newHeight - 100;
	        graphics.drawString(text, positionTextX, positionTextY);
	        
	        var fontRenderContext = graphics.getFontRenderContext();
	        var textLayout = new TextLayout(text, fonte, fontRenderContext);
	        
	        Shape outline = textLayout.getOutline(null);
	        AffineTransform transform = graphics.getTransform();
	        transform.translate(positionTextX, positionTextY);
	        graphics.setTransform(transform);
	        
	        var outlineStroke = new BasicStroke(width * 0.004f);
	        graphics.setStroke(outlineStroke);
	        
	        graphics.setColor(Color.BLACK);
	        graphics.draw(outline);
	        graphics.setClip(outline);
	        
	        ImageIO.write(newImage, "png", new File("sticker/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

