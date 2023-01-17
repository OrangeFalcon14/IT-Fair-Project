const compliments = ["Well done!", "Good job!", "Not bad!", "Congratulations!", "Nice!", "Awesome!", "Great job!"];

const usernameInp = document.querySelector("#username-inp");
const usernameError = document.querySelector("#username-error");
const countdown = document.querySelector("#countdown");
const nofification = document.querySelector("#notification");
const type = document.querySelector("#type");
const text = document.querySelector("#text");
const circleAnimation = document.querySelector("#circle-animation");

let questionsContainer = document.querySelector(".question-container");
let questionHeading = document.querySelector(".question-container h3");
let optionsContainer = document.querySelector(".question-container .options-container");
let questionNumberDisplay = document.querySelector(".question-container span");
let nextQuestionButton = document.querySelector("#next-question-btn");

let timer = 20;
let updateCountdown;

let score = 0;
let wpm = 0;
let username;

let currentTest = "gktest";

let questionNumber = 1;
let currentQuestion =  0;

let answers = {};

let gkTestScore = 0;
let iqTestScore = 0;
let opticalIllusionScore = 0;

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

const collectAnswer = (element) => {
    nextQuestionButton.disabled = false;
    let question; // = element.parentElement.parentElement.querySelector("h3").innerHTML.slice(1, 2).trim();
    questions.forEach((i) => {
        if(i.question.slice(0, -15).trim() === element.parentElement.parentElement.querySelector("h3").innerHTML.slice(4, -15).trim()){
            question = i.id;
        }
    })
    
    answers.userName = username;
    if (currentQuestion == "1") {
        if(answers.answer1) return;
        answers.question1 = question;
        answers.answer1 = element.innerHTML.at(0);
    }else if (currentQuestion == "2") {
        if(answers.answer2) return;
        answers.question2 = question;
        answers.answer2 = element.innerHTML.at(0);
    }else if (currentQuestion == "3") {
        if(answers.answer3) return;
        answers.question3 = question;
        answers.answer3 = element.innerHTML.at(0);
    }else if (currentQuestion == "4") {
        if(answers.answer4) return;
        answers.question4 = question;
        answers.answer4 = element.innerHTML.at(0);
    }else if (currentQuestion == "5") {
        if(answers.answer5) return;
        answers.question5 = question;
        answers.answer5 = element.innerHTML.at(0);
    }/* else if (currentQuestion == "6") {
        if(answers.answer6) return;
        answers.question6 = question;
        answers.answer6 = element.innerHTML.at(0);
    } */
    
    if(questions.find( element => element.id == question).answer.toLocaleLowerCase() === element.innerHTML.at(0)){
        element.classList.add("correct");
        if(currentTest == "gktest") gkTestScore += 4;
        else if(currentTest == "iqtest") iqTestScore += 4;
    }else{
        element.classList.add("incorrect")
    }

}

const nextQuestion = () => {
    if (currentQuestion == 5) {
        if(currentTest === "gktest"){
            fetch('http://localhost:8080/api/collectGKAnswers',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
            },
            body: JSON.stringify(answers)
            })
            go({to : "gktest-result-box", from : "gktest-box"});
            return;
        }else if(currentTest === "iqtest"){
            fetch('http://localhost:8080/api/collectIqAnswers',{
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
            },
            body: JSON.stringify(answers)
            })
            go({to : "iqtest-result-box", from : "iqtest-box"});
            return;
        }

    }

    nextQuestionButton.disabled = true;

    questionHeading.innerHTML = `Q${questionNumber}. ${questions[currentQuestion].question}`;
    
    optionsContainer.querySelector(":nth-child(1)").innerHTML = "a. " + questions[currentQuestion].optionA;
    optionsContainer.querySelector(":nth-child(2)").innerHTML = "b. " + questions[currentQuestion].optionB;
    optionsContainer.querySelector(":nth-child(3)").innerHTML = "c. " + questions[currentQuestion].optionC;
    optionsContainer.querySelector(":nth-child(4)").innerHTML = "d. " + questions[currentQuestion].optionD;

    optionsContainer.querySelector(":nth-child(1)").classList.remove("incorrect")
    optionsContainer.querySelector(":nth-child(2)").classList.remove("incorrect")
    optionsContainer.querySelector(":nth-child(3)").classList.remove("incorrect")
    optionsContainer.querySelector(":nth-child(4)").classList.remove("incorrect")

    optionsContainer.querySelector(":nth-child(1)").classList.remove("correct")
    optionsContainer.querySelector(":nth-child(2)").classList.remove("correct")
    optionsContainer.querySelector(":nth-child(3)").classList.remove("correct")
    optionsContainer.querySelector(":nth-child(4)").classList.remove("correct")


    questionNumberDisplay.innerHTML = `Question ${questionNumber} of 5`;

    currentQuestion++;
    questionNumber++;
}

const go = async (options) => {
    if(options.from === "username-inp-box"){
        let usernameFromInp = usernameInp.value;
        if(usernameFromInp.trim() === ""){
            usernameError.innerHTML = "Please enter a username to proceed!";
            usernameError.style.display = "block";
            return;
        }else{
            let call = await fetch("http://localhost:8080/api/userName", {
                method: "POST",
                headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*",
                },
                body: JSON.stringify({
                    userName: usernameFromInp,
                })
            })
            let response = await call.json();
            if(response.status !== "SUCCESSFUL"){
                usernameError.innerHTML = "That username isn't available! Please choose another one.";
                usernameError.style.display = "block";
                return;
            }else {
                username = response.userName;
            }
        }
    }else if(options.from === "typing-test-box"){
        let msg_output = document.querySelector("#typing-test-result-box h3");
        msg_output.innerHTML = (score > 2) ? randomElement(compliments) : "Better luck next time!";
        msg_output.classList.add((score > 2) ? "success" : "failure");

        document.querySelector("#typing-test-result-box h5:nth-of-type(1)").innerHTML += `<p style="font-size: 18px;">${score}</p>`;
        document.querySelector("#typing-test-result-box h5:nth-of-type(2)").innerHTML += `<p style="font-size: 18px;">${wpm}</p>`;

        if(score > 2) document.querySelector("#typing-test-result-box img:nth-of-type(1)").style.display = "block";
        else document.querySelector("#typing-test-result-box img:nth-of-type(2)").style.display = "block";
    }else if(options.from === "gktest-instructions-box"){
        let request = await fetch("http://localhost:8080/api/get5Questions");
        let response = await request.json();
        questions = response;
        questions.sort((a,b) => {
            return a.id - b.id;
        })
        nextQuestion();
    }else if(options.from === "gktest-box"){
        let msg_output = document.querySelector("#gktest-result-box h3");
        msg_output.innerHTML = (gkTestScore > 8) ? randomElement(compliments) : "Better luck next time!";
        msg_output.classList.add((gkTestScore > 8) ? "success" : "failure");

        document.querySelector("#gktest-result-box h5:nth-of-type(1)").innerHTML += `<p style="font-size: 18px;">${gkTestScore}</p>`;
        document.querySelector("#gktest-result-box h5:nth-of-type(2)").innerHTML += `<p style="font-size: 18px;">${gkTestScore / 4}</p>`;

        if(gkTestScore > 8) document.querySelector("#gktest-result-box img:nth-of-type(1)").style.display = "block";
        else document.querySelector("#gktest-result-box img:nth-of-type(2)").style.display = "block";
    }else if(options.from === "iqtest-instructions-box"){
        let request = await fetch("http://localhost:8080/api/get2Questions");
        let response = await request.json();
        questions = response;
        questions.sort((a,b) => {
            return a.id - b.id;
        })

        currentTest = "iqtest";

        // reset stuff
        answers = {};
        questionNumber = 1;
        currentQuestion =  0;

        questionsContainer = document.querySelector(".iq-question-container");
        questionHeading = document.querySelector(".iq-question-container h3");
        optionsContainer = document.querySelector(".iq-question-container .options-container");
        questionNumberDisplay = document.querySelector(".iq-question-container span");
        nextQuestionButton = document.querySelector(".iq-question-container > .question-footer > button");

        nextQuestion();
    }else if(options.from === "iqtest-box"){
        let msg_output = document.querySelector("#iqtest-result-box h3");
        msg_output.innerHTML = (iqTestScore > 8) ? randomElement(compliments) : "Better luck next time!";
        msg_output.classList.add((iqTestScore > 8) ? "success" : "failure");

        document.querySelector("#iqtest-result-box h5:nth-of-type(1)").innerHTML += `<p style="font-size: 18px;">${iqTestScore}</p>`;
        document.querySelector("#iqtest-result-box h5:nth-of-type(2)").innerHTML += `<p style="font-size: 18px;">${iqTestScore / 4}</p>`;

        if(iqTestScore > 8) document.querySelector("#iqtest-result-box img:nth-of-type(1)").style.display = "block";
        else document.querySelector("#iqtest-result-box img:nth-of-type(2)").style.display = "block";
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
