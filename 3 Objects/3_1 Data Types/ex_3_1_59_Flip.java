/*
3.1.59. Flip horizontally. Write a program FlipX.java that takes a command line argument which is the name of a JPG or PNG file, displays it in a window, flips the image horizontally, and displays the resulting image in the window. We illustrate using standard computer graphics test images - baboon.jpg and peppers.jpg
*/

public class ex_3_1_59_Flip {

    public static void main(String[] args) {
	
	Picture source = new Picture(args[0]); // source picture        
    int w = source.width(); // width
	int h = source.height(); // height
	Picture flipped = new Picture(w, h);
	
	// if there's even number of pixels on horizontal axe, directly flipping em
	if(w%2==0) {
	    for (int j =0; j<h; j++) {
		for (int i =0; i <w; i++) {
		    flipped.set(i,j,source.get(w-i-1,j));
		}
	    }}
	
	// if the number of horizontal pixels is odd, do twice for left and right part, not changing the middle column (lastPixel+1)
	else {
	    int lastPixel = (int)w/2;
	    for (int j =0; j<h; j++) {
		for (int i =0; i <=lastPixel; i++) {
		    flipped.set(i,j,source.get(w-i-1,j));
		}
	    }
	    for (int j =0; j<h; j++) {
		flipped.set(lastPixel+1,j,source.get(lastPixel+1,j));
	    }
	    for (int j =0; j<h; j++) {
		for (int i =lastPixel+2; i <w; i++) {
		    flipped.set(i,j,source.get(w-i-1,j));
		}
	    }
	}
	source.show();
	flipped.show();
    }   

}
