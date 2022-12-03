<script>
    export let username;
    function start_test() {
        wpm = 0;

        update_time = setInterval(() => {
            timer--;
            if(timer == 0){
                test_completed = true;
                parse_text();
                textarea_disabled = true;
                clearInterval(update_time)
            }
        }, 1000);

        textarea_disabled  = false;
        textarea_value = "";
        setTimeout(() => document.getElementById("type").focus(), 50)
    }

    let update_time;

    let wpm = 0;

    let timer = 20;

    let textarea_disabled = true;

    let textarea_value = "";

    let test_completed = false;

    $: timer_string = `${timer}s`;

    function parse_text() {
        let correct_words = "";

        let ideal_text = document.getElementById("text").textContent.split(" ");

        for (let i = ideal_text.length; i > 0; i--) {
            if(ideal_text[i] == "")ideal_text.splice(i, 1);
        }

        console.log(ideal_text);

        let typed_text = document.getElementById("type").value;

        ideal_text/* .split(" ") */.forEach((word, index) => {
            try{
                let typed_word = typed_text.split(" ")[index].toLocaleLowerCase()
                console.log(typed_word, word.toLocaleLowerCase());
                if(word.toLocaleLowerCase() == typed_word)correct_words += " " + typed_word;
            }catch(TypeError){
                return;
            }
        })

        console.log(correct_words);

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
            wpm = parseInt(data.userTypedSpeed);
        })

    }

    function handle_paste(){
        alert("We don't tolerate cheaters. Get lost!");
        clearInterval(update_time);
        timer = 0;
        wpm = 0;
    }
</script>

<button on:click|once={start_test}>Start</button>
<br /><br />
<div id="timer">{ timer_string }</div>
<p>
    Type the following paragraphs as fast as you can without making mistakes
    within 20 seconds:
</p>
<div id="test-container">
    <div id="text">
        veritatis aspernatur placeat numquam ut dicta aliquam et autem aut
        labore minima sit qui at dolorum ut aperiam odio amet eum incidunt aut
        voluptatem omnis dolor quisquam vero et et voluptas aut odio
        consequuntur minus omnis doloribus<br /><br />qui quasi qui aliquid
        placeat dolorem nesciunt numquam sunt aperiam autem autem quis earum est
        expedita expedita et voluptate quidem est non aut neque ipsam est
        molestias aliquam in consequatur quia incidunt reiciendis necessitatibus
    </div>
    <br>
    <textarea name="type" id="type" cols="30" rows="10" on:paste|preventDefault={handle_paste} bind:value={textarea_value} disabled={textarea_disabled} />
    <br><br>
    <div id="wpm">Score: { wpm }</div>
    <br />
    {#if test_completed}
        <button on:click>Next</button>
    {/if}
</div>

<style>
    #type {
        width: 65%;
        font-size: 15px;
        resize: vertical;
    }
    #text {
        margin: 0 auto;
        width: auto;
        max-width: 65%;
        text-align: left;
        padding: 10px;
        border-radius: 10px;
        font-size: 18px;
        /* background: #001d34; */
    }
    #timer {
        font-size: 30px;
    }
    #test-container {
        padding: 5px;
        /* background-color: #fff; */
    }
</style>
