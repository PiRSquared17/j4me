package org.j4me.ui.components;

import javax.microedition.lcdui.*;
import org.j4me.ui.*;

/**
 * A horizontal rule component.  It is a line across the screen used
 * to demarkate sections of a form.
 */
public class HorizontalRule
	extends Component
{
	/**
	 * The height of the line.
	 */
	private static final int HEIGHT = 1;
	
	/**
	 * The percentage of the screen's width the horizontal rule
	 * occupies.
	 */
	private double widthPercentage = 0.90;  // 90%

	/**
	 * Constructs a horizontal rule component.
	 */
	public HorizontalRule ()
	{
		// Center justified by default.
		setHorizontalAlignment( Graphics.HCENTER );
	}
	
	/**
	 * Sets how far across the screen the line extends.
	 * 
	 * @param percentageOfScreen is the length of the line relative
	 *  to the width of the screen.  It must be between 0.00 and 1.00.
	 */
	public void setWidthOfScreen (double percentageOfScreen)
	{
		if ( (percentageOfScreen < 0.0) || (percentageOfScreen > 1.0) )
		{
			// The percentage must be between 0.00 and 1.00.
			throw new IllegalArgumentException( String.valueOf(percentageOfScreen) );
		}
		
		this.widthPercentage = percentageOfScreen;
	}
	
	/**
	 * Gets how far across the screen the line extends.
	 * 
	 * @return The length of the line relative to the width of
	 *  the screen.
	 */
	public double getWidthOfScreen ()
	{
		return widthPercentage;
	}
	
	/**
	 * Paints the horizontal rule.
	 * 
	 * @see org.j4me.ui.components.Component#paintComponent(javax.microedition.lcdui.Graphics, org.j4me.ui.Theme, int, int, boolean)
	 */
	protected void paintComponent (Graphics g, Theme theme, int width, int height, boolean selected)
	{
		// Calculate the line's dimensions.
		int lineWidth = (int)( width * widthPercentage );
		int lineX;
		
		switch ( getHorizontalAlignment() )
		{
		case Graphics.LEFT:
			lineX = 0;
			break;
		case Graphics.HCENTER:
			lineX = (width - lineWidth) / 2;
			break;
		default:  // Graphics.RIGHT:
			lineX = width - lineWidth;
		}
		
		// Set the color for the line.
		int color = theme.getBorderColor();
		g.setColor( color );
		
		// Draw the line.
		g.drawLine( lineX, 0, lineX + lineWidth, 0 );
	}

	/**
	 * Returns the size of the horizontal rule.
	 * 
	 * @see org.j4me.ui.components.Component#getPreferredComponentSize(org.j4me.ui.Theme, int, int)
	 */
	protected int[] getPreferredComponentSize (Theme theme, int viewportWidth, int viewportHeight)
	{
		return new int[] { viewportWidth, HEIGHT };
	}
}
