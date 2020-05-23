//By: Arnav Garg

import java.awt.Color;

public class SandUtilities
{
    //pre : c != null
    //post: returns the inverted color from the one sent as c
    public static Color invert(Color c)
    {
        return new Color(255-c.getRed(), 255-c.getGreen(), 255-c.getBlue());
    }
   
    //pre:   m != null
    //post:  for each non-null element of m, changes it to its inverted color
    //       skips any color with the value skip1 and skip2, leaving them unchanged
    public static void invertColors(Color[][]m, Color skip1, Color skip2)
    {
        for(int r = 0; r < m.length; r++) //rows
        {
         for(int c = 0; c < m[0].length; c++) //columns
         {
            if(m[r][c] != null && m[r][c] != skip1 && m[r][c] != skip2)
            {
                invert(m[r][c]);
            }
         }
        }
    }
   
    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  flips the array upside down
    public static void flipUpsideDown(Object[][]m)
    {
        for(int r = 0; r < m.length/2; r++) //rows
        {
           swap(m, r, -1);
        }
    }
   
    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  rotates the array 90 degrees to the left
    public static void rotateLeft(Object[][] m) 
    {
        transpose(m);
        for(int r = 0; r < m.length/2; r++) //rows
        {
           swap(m, r, -1);
        }
    }
    
    //pre:   m is a square 2-D array (m.length==m[0].length)
    //post:  rotates the array 90 degrees to the right
    public static void rotateRight(Object[][] m)
    {
        transpose(m);
        for(int r = 0; r < m.length/2; r++) //rows
        {
           for(int c =0; c<m[0].length; c++)
           {
               swap(m, r, c);
           }
        }
    }  

    public static void swap(Object[][] m, int r, int c)
    { 
        if(c==-1)
        {
            Object[] temp = m[r];
            m[r]= m[m.length - r - 1];
            m[m.length - r - 1] = temp;
        }
        else
        {
           Object temp = m[c][r];
           m[c][r]= m[c][m.length - r - 1];
           m[c][m.length - r - 1] = temp; 
        }
    } 
    
    
    public static void transpose(Object[][] m) 
    { 
        for(int r = 0; r < m.length; r++) //rows
        {
         for(int c = r; c < m[0].length; c++) //columns
         {
            Object temp = m[c][r]; 
            m[c][r] = m[r][c]; 
            m[r][c] = temp;
         }
        }
    }
   
}