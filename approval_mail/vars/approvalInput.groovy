def call(submitterParam) {
    input message: "${submitterParam} Kindly submit you Approval to continue the build?", 
    ok: 'Approve', 
    submitter: submitterParam, 
    submitterParameter: submitterParam
}
