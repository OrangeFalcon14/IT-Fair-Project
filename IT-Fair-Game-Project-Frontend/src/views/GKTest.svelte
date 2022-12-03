<script>
    export let username;

    let questions = [];
    
    let current_question = 0;

    console.log(questions);

    let questions_loaded = false;

    fetch('http://localhost:8080/api/get5Questions')
    .then(response => {
        return response.json();
    }).then(data => {
        questions = data;
        questions.sort((a,b) => {
            return a.id - b.id;
        })
        questions = questions;
        console.log(questions);
        questions_loaded = true;
    });

    let options = []

</script>
{#if current_question === 0}
    <div id="intro">
        <p>Welcome to GK Test!</p>
        <p>This short quiz will test your general knowledge.</p>
        <br>
        <button on:click={() => {current_question++}}>Start</button>
    </div>    
{/if}
{#if questions_loaded}
    {#if current_question > 0 && current_question - 1 !== questions.length  && questions}
        {#each questions as question (question.question)}
            {#if current_question - 1 === questions.indexOf(question)}
                <div class="question">
                    <p>{`Q${question.id}. ${question.question}`}</p>
                    <form>
                        <input type="radio" value={question.optionA} name={question.question} id={question.optionA}/>
                        <label for={question.optionA}>{question.optionA}</label>
                        <br>
                        <input type="radio" value={question.optionB} name={question.question} id={question.optionB}/>
                        <label for={question.optionB}>{question.optionB}</label>
                        <br>
                        <input type="radio" value={question.optionC} name={question.question} id={question.optionC}/>
                        <label for={question.optionC}>{question.optionC}</label>
                        <br>
                        <input type="radio" value={question.optionD} name={question.question} id={question.optionD}/>
                        <label for={question.optionD}>{question.optionD}</label>
                    </form>
                    <br>
                    <button on:click={() => {current_question++}}>Next</button>
                </div>
            {/if}
        {/each}
    {/if}
    {#if current_question - 1 === questions.length}
        <div id="outro">
            <p>That's it!</p>
            <p>Thanks for participating in the GK test.</p>
            <button on:click>Next</button>
        </div>
    {/if}
{/if}
<style>
    div{
        position:absolute;
        top: 50%;
        left:50%;
        transform: translate(-50%, -50%);
    }
    #intro, #outro, .question{
        width: 50%;
        padding: 20px;
        border-radius: 10px;
        font-size: 20px;
        /* background: #001d34; */
    }
    .question form{
        margin: 0 auto;
        width: fit-content;
        text-align: left;
    }
    input[type="radio"]{
        margin-left: 40px;
    }
</style>
