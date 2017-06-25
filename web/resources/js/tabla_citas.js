$().ready(function () {

    $('#pdf').click(function () {
        $('#table').bootstrapTable('checkAll');
        $('#table').tableExport({
            type: 'pdf',
            escape: false,
            pdfFontSize: 10,
            fileName: "Historial"
        });
    });

    $('#png').click(function () {

        $('#table').tableExport({
            type: 'png',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#json').click(function () {
        $('#table').tableExport({
            type: 'json',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#xml').click(function () {
        $('#table').tableExport({
            type: 'xml',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#txt').click(function () {
        $('#table').tableExport({
            type: 'txt',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#sql').click(function () {
        $('#table').tableExport({
            type: 'sql',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#csv').click(function () {
        $('#table').tableExport({
            type: 'csv',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#word').click(function () {
        $('#table').tableExport({
            type: 'word',
            escape: false,
            fileName: "Historial"
        });
    });

    $('#excel').click(function () {
        $('#table').tableExport({
            type: 'excel',
            escape: false,
            fileName: "Historial"
        });
    });

});


