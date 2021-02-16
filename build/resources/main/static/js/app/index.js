var main = {
    init : function () {
    var _this = this;
    $('#btn-save').on('click', function() {
        _this.save();
    });
    $('#btn-update').on('click', function() { //btn-update라는 id를 가진 html엘리먼트에 click이벤트가 발생할 때 update 함수를 실행하도록 이벤트 등록
        _this.update();
    });
    $('#btn-delete').on('click', function() {
        _this.delete();
    });
    },
    save : function() {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts',
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/'; //글을 등록하면 메인페이지로 돌아감
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    },
    update : function() {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT', // 생성(create) : POST, 읽기(Read) : GET, 수정(update) : PUT, 삭제(delete) : DELETE
            url: '/api/v1/posts/' + id, // 어느 게시글을 수정할지 url path로 구분하기 위해 id를 추가
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        })
    },
    delete : function() {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8'
        }).done(function() {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};
main.init();