<script>
    
    // fetch('http://localhost:8080/api/get5Questions').then(response =>{
        //         return response.json();
        //     }).then(data =>{
            //         questions = data;
            //     })
    let questions = [];

    let current_question = 0;
        
    questions = JSON.parse(`
    [
    {
        "question": "lorem ipsum dolor et simet",
        "optionA": "a1",
        "optionB": "b1",
        "optionC": "c1",
        "optionD": "d1"
    },
    {
        "question": "lorem ipsum dolor et simet blah blah",
        "optionA": "a2",
        "optionB": "b2",
        "optionC": "c2",
        "optionD": "d2"
    }
    ]`)

    console.log(questions);


    // let request = new XMLHttpRequest();
    // request.open("GET", "http://localhost:8080/api/get5Questions", false);
    // request.send();
    // request.onload = () => {
    //     questions = JSON.parse(request.response);
    // }

    // function next_question() {
    //     if(current_question == 1){
    //         // document.querySelector("#intro").style.display = "none";

    //         // let next_btn = document.createElement("button");
    //         // next_btn.id="next_btn";
    //         // next_btn.onclick = next_question;
    //         // next_btn.innerHTML = "Next";
    //         // container.appendChild(next_btn);
    //     }

    //     if(current_question - 1 == questions.length){
    //         // document.getElementById("question" + (current_question - 1)).style.display = "none";
    //         // document.getElementById("next_btn").style.display = "none";
    //         // document.querySelector("#outro").style.display = "block";
    //         return;
    //     }
        
    //     // question = questions[current_question - 1];
    //     // create_question(question);

    //     try{
    //         document.getElementById("question" + (current_question - 1)).style.display = "none";
    //     }catch {
    //         1 + 1;
    //     }

        
    //     current_question ++;
    // }

    // function create_question(question){
    //     let question_element = document.createElement("div");
    //     question_element.id = "question" + current_question;

    //     let question_label = document.createElement("p");
    //     question_label.innerHTML = question.question;
    //     question_element.appendChild(question_label);

    //     let question_form = document.createElement("form");
    //     question_element.appendChild(question_form)

    //     // for (let i = 0; i < question.options.length; i++) {
    //     //     let option = document.createElement("input");
    //     //     option.type = "radio";
    //     //     option.value = question.options[i]
    //     //     option.name = question.question;
    //     //     question_form.appendChild(option);

    //     //     let option_label = document.createElement("label");
    //     //     option_label.htmlFor = option.name;
    //     //     option_label.innerHTML = option.value;
    //     //     question_form.appendChild(option_label);

    //     //     question_form.innerHTML += "<br>";
    //     // }

    //     let option_a = document.createElement("input")
    //     option_a.type = "radio";
    //     option_a.value = question.optionA;
    //     option_a.name = question.question;
    //     question_form.appendChild(option_a);

    //     let option_b = document.createElement("input")
    //     option_b.type = "radio";
    //     option_b.value = question.optionB;
    //     option_b.name = question.question;
    //     question_form.appendChild(option_b);

    //     let option_c = document.createElement("input")
    //     option_c.type = "radio";
    //     option_c.value = question.optionC;
    //     option_c.name = question.question;
    //     question_form.appendChild(option_c);

    //     let option_d = document.createElement("input")
    //     option_d.type = "radio";
    //     option_d.value = question.optionD;
    //     option_d.name = question.question;
    //     question_form.appendChild(option_d);

    //     container.appendChild(question_element)
    // }
</script>
{#if current_question === 0}
    <div id="intro">
        <p>Welcome to GK Test!</p>
        <p>This short quiz will test your general knowledge.</p>
        <!-- <button style="background-color: red;" onclick="next_question()">Start</button> -->
        <button style="background-color: red;" on:click={() => {current_question++}}>Start</button>
    </div>    
{/if}
{#if current_question > 0 && current_question - 1 !== questions.length  && questions}
    {#each questions as question (question.question)}
        {#if current_question - 1 === questions.indexOf(question)}
            <div>
                <p>{question.question}</p>
                <form>
                    <input type="radio" value={question.optionA} name={question.question}/>
                    <label>{question.optionA}</label>
                    <br>
                    <input type="radio" value={question.optionB} name={question.question}/>
                    <label>{question.optionB}</label>
                    <br>
                    <input type="radio" value={question.optionC} name={question.question}/>
                    <label>{question.optionC}</label>
                    <br>
                    <input type="radio" value={question.optionD} name={question.question}/>
                    <label>{question.optionD}</label>
                </form>
                <br>
                <button style="background-color: red;" on:click={() => {current_question++}}>Next</button>
            </div>
        {/if}
    {/each}
{/if}
{#if current_question - 1 === questions.length}
    <div id="outro">
        <p>That's it!</p>
        <p>Thanks for participating in the GK test.</p>
        <button on:click style="background-color: red">Next</button>
    </div>
{/if}
