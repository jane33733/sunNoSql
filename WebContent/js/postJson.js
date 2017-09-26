function postJson(url, data, successCallback, errorCallback) {
    if (!url) {
        return;
    }
    if (!successCallback) {
        successCallback = function () {};
    }
    if (!errorCallback) {
        errorCallback = function () {};
    }
    return jQuery.ajax({
        url: url,
        type: "POST",
        contentType: "application/json; charset=utf-8",
        dataType: "json",
        data: JSON.stringify(data),
        success: successCallback,
        error: errorCallback
    });
}

function postForm(url, data, successCallback, errorCallback) {
    if (!successCallback) {
        successCallback = function () {};
    }
    if (!errorCallback) {
        errorCallback = function () {};
    }
    return jQuery.ajax({
        url: url,
        type: "POST",
        dataType: "json",
        data: data,
        success: successCallback,
        error: errorCallback
    });
}

function uploadFile(url, form, success, error, notify) {
    var xhr = new XMLHttpRequest();
    xhr.open('POST', url, true);
    xhr.upload.onprogress = function (e) {
        if (typeof (notify) === 'function') {
            if (e.lengthComputable) {
                var percentComplete = (e.loaded / e.total) * 100;
                notify(percentComplete);
            }
        }
    };
    xhr.onload = function () {
        if (this.status == 200) {
            if (typeof (success) === 'function') {
                var response = this.response;
                var contentType = this.getResponseHeader('Content-Type')
                if (contentType.toLowerCase().indexOf('json') > -1) {
                    success(JSON.parse(response));
                } else {
                    success(response);
                }
            }
        } else {
            error();
        }
    };
    xhr.send(form);
}
