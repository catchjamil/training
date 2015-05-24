package docview3;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class EncodeImage {


    public static BufferedImage encodeImage(byte[] bytes) {

        double root = Math.sqrt(Math.ceil(bytes.length/4)+4);
        int introot = (int) Math.ceil(root);
        int arrayLength = introot* introot *4;




        int [] imageInts = new int[arrayLength];
        imageInts[0] = bytes.length>>>24 & 0xff;
        imageInts[1] = bytes.length>>>16 & 0xff;
        imageInts[2] = bytes.length>>>8 & 0xff;
        imageInts[3] = bytes.length & 0xff;


        for(int count = 0; count < bytes.length; count ++) {
            imageInts[count+4] = (bytes[count]&0xff);
        }

        BufferedImage image = new BufferedImage(introot, introot, BufferedImage.TYPE_4BYTE_ABGR );
        WritableRaster bobMarley = image.getRaster();
        bobMarley.setPixels(0, 0, introot, introot, imageInts);

        return(image);
    }


    public static byte[] decodeImage(BufferedImage image) {
        image.getRaster();
        WritableRaster rast = image.getRaster();
        int[] intArray = rast.getPixels(0, 0, image.getWidth(), image.getHeight(), new int[image.getWidth()*image.getHeight()*4]);
        int length = (intArray[0]<<24 & 0xff000000)|
                     (intArray[1]<<16 & 0x00ff0000)|
                     (intArray[2]<<8  & 0x0000ff00)|
                      (intArray[3]     & 0x000000ff);

        byte[] result = new byte[length];
        for(int count = 0; count < length; count ++) {
             result[count]  = (byte)(intArray[count+4] & 0xff);
        }

        return result;
    }

     /**
     * Returns the contents of the file in a byte array
     * @param file File this method should read
     * @return byte[] Returns a byte[] array of the contents of the file
     */
    private static byte[] getBytesFromFile(File file) throws IOException {

        InputStream is = new FileInputStream(file);
        System.out.println("\nDEBUG: FileInputStream is " + file);

        // Get the size of the file
        long length = file.length();
        System.out.println("DEBUG: Length of " + file + " is " + length + "\n");

        /*
         * You cannot create an array using a long type. It needs to be an int
         * type. Before converting to an int type, check to ensure that file is
         * not loarger than Integer.MAX_VALUE;
         */
        if (length > Integer.MAX_VALUE) {
            System.out.println("File is too large to process");
            return null;
        }

        // Create the byte array to hold the data
        byte[] bytes = new byte[(int)length];

        // Read in the bytes
        int offset = 0;
        int numRead = 0;
        while ( (offset < bytes.length)
                &&
                ( (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) ) {

            offset += numRead;

        }

        // Ensure all the bytes have been read in
        if (offset < bytes.length) {
            throw new IOException("Could not completely read file " + file.getName());
        }

        is.close();
        return bytes;

    }


    public static void main(String[] args) throws Exception{
        if(args.length != 3) {
            System.err.println("Usage: EncodeImage [-enc|-dec|-tst] <infile> <outfile>");
            System.exit(1);
        }

        if ("-tst".equals(args[0])) {
            File f = new File(args[1]);
            byte[] fbytesIn  = getBytesFromFile(f);
            BufferedImage bout = encodeImage(fbytesIn);

            ImageIO.write(bout, "png", new File(args[2]));


            BufferedImage bin =ImageIO.read(new File(args[2]));
            byte[] fbytesOut = decodeImage(bin);

            File newfile = new File(f.getParent(), "dec-" + f.getName());
            FileOutputStream fos = new FileOutputStream(newfile);
            fos.write(fbytesOut);
            fos.close();
        }
        else if ("-enc".equals(args[0])) {
            File f = new File(args[1]);
            byte[] fbytes  = getBytesFromFile(f);
            BufferedImage b = encodeImage(fbytes);
            ImageIO.write(b, "png", new File(args[2]));
        }
        else if ("-dec".equals(args[0])) {
            BufferedImage b =ImageIO.read(new File(args[1]));
            byte[] fbytes = decodeImage(b);
             FileOutputStream fos = new FileOutputStream(args[2]);
             fos.write(fbytes);
             fos.close();
        }
        else {
            System.err.println("Usage: EncodeImage [-enc|-dec] <infile> <outfile>");
            System.exit(1);
        }

    }

} 