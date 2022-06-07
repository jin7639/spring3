function data_create(){
    let name = $("#name").val();
    let phone = $("#phone").val();
    let memo = $("#memo").val();
    $.ajax({    //비동기
        url: "create",  //통신 경로
        method: "POST", //통신 방식
        data: {"name": name, "phone": phone, "memo" : memo},    //통신 데이터
        success: function(result){  //통신 응답
            alert("RESTFUL read 통신");
        }
    });
}

function data_read(){
    alert("호출");
     $.ajax({
        url: "read",
        method: "get",
        success: function(result){

            alert("RESTFUL read 통신");
            alert(result);
        }
    });
}
function data_update(){
    alert("수정");
     $.ajax({
        url: "update",
        method: "put",
        success: function(result){
            alert("RESTFUL read 통신");
        }
    });
}
function data_delete(){
    alert("삭제");
     $.ajax({
        url: "delete",
        method: "delete",
        success: function(result){
            alert("RESTFUL read 통신");
        }
    });
}
