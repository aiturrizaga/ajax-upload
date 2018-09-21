function cargarImagen() {
    var url = "http://localhost:9090/ap/FileUpload";
    var form = $("#sampleUploadFrm")[0];
    var data = new FormData(form);
    $.ajax({
        type: "POST",
        encType: "multipart/form-data",
        url: url,
        cache: false,
        processData: false,
        contentType: false,
        data: data,
        success: function (msg) {
            var response = JSON.parse(msg);
            var status = response.status;
            if (status == 1) {
                alert("File has been uploaded successfully");
            } else {
                alert("Couldn't upload file");
            }
        },
        error: function (msg) {
            alert("Couldn't upload file");
        }
    });
}