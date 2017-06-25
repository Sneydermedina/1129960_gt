$(".archivo").on("change", function (e) {

    var archivos = $(this)[0].files;

    if (archivos.length > 1) {
        $(".btn-archivo").text(archivos.length + " archivos seleccionados");
    } else{
        $(".btn-archivo").text(e.target.value.split("\\").pop());
    }
});

