import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

class ShapedButtonUI extends BasicButtonUI {

  /** Button shape. */
  private ButtonShape shape;
  private Color color;

  public ShapedButtonUI() {
   super();
  }

  public void setShape(ButtonShape shape, JButton button, Color colores){
   button.setBorderPainted(false);
   button.setOpaque(false);
   button.setRolloverEnabled(false);//
   button.setRolloverEnabled(false);//RECUERDA AGREGAR ESTO MAMON /////////////////////////////////////////////////////////////////////////
   button.setContentAreaFilled(false);
   button.setFocusPainted(false);
   this.shape = shape;
   this.color=colores;
  }

  @Override
  public void paint(Graphics g, JComponent c) {

   Graphics2D g2d = (Graphics2D) g;

   Shape buttonShape = null;
   switch (shape) {
    case ROUND:
     buttonShape = new RoundRectangle2D.Double(0, 0, c.getWidth() - 1, c.getHeight() - 1, 20, 20);
     break;
    case SQUARE:
     buttonShape = new Rectangle(0, 0, c.getWidth(), c.getHeight());
     break;
    case POLYGON:
     int[] xPoints = {0, 0 + c.getWidth() / 3, 0 + 2 * (c.getWidth() / 3), c.getWidth(), 0 + 2 * (c.getWidth() / 3), 0 + c.getWidth() / 3};
     int[] yPoints = {c.getHeight() / 2, 0, 0, c.getHeight() / 2, c.getHeight(), c.getHeight()};
     buttonShape = new Polygon(xPoints, yPoints, 6);
     break;
   }
   g2d.setColor(color);
   g2d.fill(buttonShape);
   super.paint(g2d, c);

  }

  @Override
  protected void paintButtonPressed(Graphics g, AbstractButton b) {
   Graphics2D g2d = (Graphics2D) g;

   Shape buttonShape = null;
   switch (shape) {
    case ROUND:
     buttonShape = new RoundRectangle2D.Double(0, 0, b.getWidth() - 1, b.getHeight() - 1, 20, 20);
     break;
    case SQUARE:
     buttonShape = new Rectangle(0, 0, b.getWidth(), b.getHeight());
     break;
    case POLYGON:
     int[] xPoints = {0, 0 + b.getWidth() / 3, 0 + 2 * (b.getWidth() / 3), b.getWidth(), 0 + 2 * (b.getWidth() / 3), 0 + b.getWidth() / 3};
     int[] yPoints = {b.getHeight() / 2, 0, 0, b.getHeight() / 2, b.getHeight(), b.getHeight()};
     buttonShape = new Polygon(xPoints, yPoints, 6);
     break;
   }
   g2d.setColor(new Color(186,105,15));
   g2d.fill(buttonShape);
  }
 }