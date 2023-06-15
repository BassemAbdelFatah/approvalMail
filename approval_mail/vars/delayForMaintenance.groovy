def call(){
    def cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
    cal.set(Calendar.HOUR_OF_DAY, 1)
    cal.set(Calendar.MINUTE, 0)
    cal.set(Calendar.SECOND, 0)
    cal.set(Calendar.MILLISECOND, 0)
            
    def now = new Date()
    println(now)
    if (cal.timeInMillis <= now.time) {
        cal.add(Calendar.DAY_OF_MONTH, 1)
    }
    def timeToWait = ((cal.timeInMillis - now.time) / 1000 / 60) - 180

    println "Waiting for ${timeToWait} minutes until 1:00 am"
    sleep(time: timeToWait, unit: "MINUTES")
}
