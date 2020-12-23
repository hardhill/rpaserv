function connect() {
    var socket = new SockJS('/wsrpa');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log("connected: " + frame);
        stompClient.subscribe('/pool/messages', function (response) {
            var data = JSON.parse(response.body);
            draw("left", data.message);
        });
    });
}

function draw(side, text) {
    console.log("drawing...");
    var $message;
    $message = $($('.message_template').clone().html());
    $message.addClass(side).find('.text').html(text);
    $('.messages').append($message);
    return setTimeout(function () {
        return $message.addClass('appeared');
    }, 0);

}

function disconnect() {
    stompClient.disconnect();
}

function sendMessage() {
    stompClient.send("/app/botmessage", {}, JSON.stringify({'message': $("#message_input_value").val()}));

}