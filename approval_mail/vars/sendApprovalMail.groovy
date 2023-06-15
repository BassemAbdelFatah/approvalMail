def call(approvalList) {
    for (email in approvalList) {
        def approvalName = email.substring(0, email.indexOf('@'))
        def MAIL_FILE = "/home/user/approvemail/index_${approvalName}.html"
        sh "sed 's|BasimHolder1|${approvalName}|g; s|BasimJobName|${env.JOB_NAME}|g; s|https://Basimlink|${BUILD_URL}input|g' /home/user/approvemail/index.html > ${MAIL_FILE}"
        def htmlFileContents = readFile(file: MAIL_FILE)
        sh "rm -rf ${MAIL_FILE}"
        emailext to: email, 
        body: htmlFileContents, 
        recipientProviders: [
            [$class: 'DevelopersRecipientProvider'], [$class: 'RequesterRecipientProvider']
        ], 
        subject: "Jenkins Build Approval: Job ${env.JOB_NAME}", 
        mimeType: 'text/html'
    }
}
