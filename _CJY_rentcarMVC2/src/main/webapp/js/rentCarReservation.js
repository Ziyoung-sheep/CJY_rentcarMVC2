const form = document.querySelector('form');
const startDayInput = document.getElementById('startDay');
const rentDayInput = document.getElementById('rentDay');
const qtyInput = document.getElementById('qty');
const submitButton = document.getElementById('submit_btn'); // submitButton 수정
let ctx = window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

const today = new Date();
today.setHours(0, 0, 0, 0);

submitButton.addEventListener('click', function(event) {
    event.preventDefault();

    const startDay = new Date(startDayInput.value);

    if (startDay < today) {
        alert('예약일은 오늘 이후로 선택해주세요.');
        startDayInput.value = '';
        return;
    }

    const rentDay = parseInt(rentDayInput.value);
    const qty = parseInt(qtyInput.value);
    const carNum = form.querySelector('input[name="carNum"]').value;
    const startDate = startDayInput.value;

    fetch(`${ctx}/rentCarCheck.do?startDay=` + startDate + '&rentDay=' + rentDay + '&qty=' + qty + '&carNum=' + carNum) // qty 추가
        .then(response => response.text())
        .then(data => {
            if (data === 'valid') {
				console.log('들어오긴 하나');
                form.submit();
            } else {
                alert('해당 날짜에 예약 가능한 차량이 없습니다.');
            }
        })
        .catch(error => {
            console.log(error);
            alert('서버 오류가 발생했습니다.');
        });
});