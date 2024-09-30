public class LogReport {
    private String date;
    private String log;
    private String message;
    public LogReport(String date, String log, String message) {
        this.date = date;
        this.log = log;
        this.message = message;
    }
    public String getDate() {
        return date;
    }
    public String getLog() {
        return log;
    }
    public String getMessage() {
        return message;
    }
}
