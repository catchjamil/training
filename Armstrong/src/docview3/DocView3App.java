

package docview3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;
import org.jdesktop.application.Task;

public class DocView3App extends SingleFrameApplication {

    @Override protected void startup() {
      // System.out.println(new DocView3View(this));
    	 System.out.println("Application is about to start...");
        show(new DocView3View(this));
    }
    @Override protected void configureWindow(java.awt.Window root) {
    }

    public static DocView3App getApplication() {
        return Application.getInstance(DocView3App.class);
    }
    public static void main(String[] args) {
        launch(DocView3App.class, args);
    }

     static class LoadTextFileTask extends Task<String, Void> {

        private final File file;


         LoadTextFileTask(Application application, File file) {
            super(application);
            this.file = file;
        }


         public final File getFile() {
            return file;
        }



         @Override
        protected String doInBackground() throws IOException {
            int fileLength = (int) file.length();
            int nChars = -1;
            
            int blockSize = Math.max(1024, fileLength / 100);
            int p = blockSize;
            char[] buffer = new char[32];
            StringBuilder contents = new StringBuilder();
            BufferedReader rdr = new BufferedReader(new FileReader(file));
            while (!isCancelled() && (nChars = rdr.read(buffer)) != -1) {
                contents.append(buffer, 0, nChars);
                if (contents.length() > p) {
                    p += blockSize;
                    setProgress(contents.length(), 0, fileLength);
                }
            }
            if (!isCancelled()) {
                return contents.toString();
            } else {
                return null;
            }
        }


}
}
