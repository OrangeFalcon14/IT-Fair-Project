const compliments = ["Well done!", "Good job!", "Not bad!", "Congratulations!", "Nice!", "Awesome!", "Great job!"];

const usernameInp = document.querySelector("#username-inp");
const usernameError = document.querySelector("#username-error");
const countdown = document.querySelector("#countdown");
const nofification = document.querySelector("#notification");
const type = document.querySelector("#type");
const text = document.querySelector("#text");
const circleAnimation = document.querySelector("#circle-animation");

let timer = 20;
let updateCountdown;

let score = 0;
let wpm = 0;
let username;

const randomElement = (array) => {
    return array.at(Math.floor(Math.random() * array.length));
}

const handlePaste = (event) => {
    event.preventDefault();
    
    alert("We don't tolerate cheaters. Get lost!");
    clearInterval(updateCountdown);
    countdown.style.display = "none";
    document.querySelector("#typing-test-scores-btn").style.display = "inline";
    timer = 0;

    fetch('http://localhost:8080/api/wpm',{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        },
        body: JSON.stringify({
            userName: username,
            userTyped: ""
        })
    }).then(response =>{
        return response.json();
    }).then(data =>{
        score = parseInt(data.userScore);
        wpm = parseInt(data.userTypedSpeed);
    })
}

type.addEventListener("paste", handlePaste)

const go = (options) => {
    if(options.from === "username-inp-box"){
        let usernameFromInp = usernameInp.value;
        if(usernameFromInp.trim() === ""){
            usernameError.innerHTML = "Please enter a username to proceed!";
            usernameError.style.display = "block";
            return;
        }else{
            fetch("http://localhost:8080/api/userName", {
                method: "POST",
                headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
                },
                body: JSON.stringify({
                    userName: usernameFromInp,
                })
            }).then(response => {
                return response.json();
            }).then(data => {
                if(data.status !== "SUCCESSFUL"){
                    usernameError.innerHTML = "That username isn't available! Please choose another one.";
                    usernameError.style.display = "block";
                    return;
                }else {
                    username = date.userName;
                }
            });
        }
    }else if(options.from === "typing-test-box"){
        let msg_output = document.querySelector("#typing-test-result-box h3");
        msg_output.innerHTML = (score > 3) ? randomElement(compliments) : "Better luck next time!";
        msg_output.classList.add((score > 3) ? "success" : "failure");

        document.querySelector("#typing-test-result-box h5:nth-of-type(1)").innerHTML += `<p style="font-size: 18px;">${score}</p>`;
        document.querySelector("#typing-test-result-box h5:nth-of-type(2)").innerHTML += `<p style="font-size: 18px;">${wpm}</p>`;

        if(score > 3) document.querySelector("#typing-test-result-box img:nth-of-type(1)").style.display = "block";
        else document.querySelector("#typing-test-result-box img:nth-of-type(2)").style.display = "block";
    }

    let to = document.querySelector(`#${options.to}`);
    let from = document.querySelector(`#${options.from}`);
    from.classList.add("hide");
    from.classList.remove("show");
    to.classList.add("show");
    to.classList.remove("hide");
}

const parseText = () => {
    let correct_words = "";

    let ideal_text = text.textContent.split(" ");

    for (let i = ideal_text.length; i > 0; i--) {
        if(ideal_text[i] == "")ideal_text.splice(i, 1);
    }

    let typed_text = type.value;

    ideal_text.forEach((word, index) => {
        try{
            let typed_word = typed_text.split(" ")[index].toLocaleLowerCase()
            if(word.toLocaleLowerCase() == typed_word)correct_words += " " + typed_word;
        }catch(TypeError){
            return;
        }
    })

    fetch('http://localhost:8080/api/wpm',{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*",
        },
        body: JSON.stringify({
            userName: username,
            userTyped: correct_words
        })
    }).then(response =>{
        return response.json();
    }).then(data =>{
        score = parseInt(data.userScore);
        wpm = parseInt(data.userTypedSpeed);
    })

}

const startTypingTest = () => {
    document.querySelector("#typing-test-start-btn").style.display = "none";
    countdown.style.display = "block";

    type.value = "";
    type.disabled = false;
    type.focus();

    // let initialOffset = '440';

    // circleAnimation.style.strokeDashoffset = initialOffset-(1*(initialOffset/timer));

    updateCountdown = setInterval(() => {
        let i = timer - 20;
        timer--;
        countdown.innerHTML = `${timer}s`;
        // circleAnimation.style.strokeDashoffset = initialOffset-((i - 1) * (initialOffset / timer));
        if(timer == 0){
            countdown.style.display = "none";
            nofification.style.bottom = "5%";
            document.querySelector("#typing-test-scores-btn").style.display = "inline"
            type.disabled = true;
            setTimeout(() => {
                notification.style.bottom = "-100%";
            }, 5 * 1000);
            parseText()
            clearInterval(updateCountdown);
        }
    }, 1000);
}
