package JavaConcurrency;

public class InterruptMethodExample {

    class FileDownloader extends Thread {
        private String url;
        private boolean canceled = false;

        public FileDownloader(String url) {
            this.url = url;
        }

        public void run() {
            try {
                // Download the file from the URL (time-consuming operation).
                downloadFileFromUrl(url);

                // Check if the download was canceled.
                if (isInterrupted() || canceled) {
                    System.out.println("Download canceled for: " + url);
                } else {
                    System.out.println("Download completed for: " + url);
                }
            } catch (InterruptedException e) {
                System.out.println("Download interrupted for: " + url);
            }
        }

        public void cancelDownload() {
            canceled = true;
            interrupt(); // Interrupt the thread to stop the download.
        }

        private void downloadFileFromUrl(String url) throws InterruptedException {
            // Simulate the download process (blocking operation).
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(1000); // Simulate downloading for 10 seconds.
                if (canceled) {
                    throw new InterruptedException(); // If canceled, interrupt the thread.
                }
            }
        }
    }

}
