<script>
    import Welcome from "./views/Welcome.svelte";
    import Typing from './views/Typing.svelte';
    import GKTest from "./views/GKTest.svelte";
    import IQTest from "./views/IQTest.svelte";
    import OpticalIllusion from "./views/OpticalIllusion.svelte";

    let views = ["welcome", "typing", "gktest", "optical_illusion", "iq_test"];
    let currentTest = 0;

    let userDetails = {
        userName: null,
        userTyped: null,
        
    }

    let next_test = (event = null) => {
        if(event !== null){
            userDetails.userName = event.detail;
        }
        currentTest++;
    };
</script>

<div id="container">
    {#if currentTest == 0}
        <Welcome on:start={next_test} />
    {:else if currentTest == 1}
        <Typing username={userDetails.userName} on:click={next_test} />
    {:else if currentTest == 2}
        <GKTest username={userDetails.userName} on:click={next_test}/>
    {:else if currentTest == 3}
        <IQTest username={userDetails.userName} on:click={next_test} />
    {:else if currentTest == 4}
        <OpticalIllusion username={userDetails.userName} on:click={next_test} />
    {/if}
</div>

<style>
    #container {
        padding: 50px;
        width: 50%;
        /* height: calc(100vh - 100px); */
        height: calc(100% - 100px);
        max-height: 100%;
        /* position: absolute;
        left: 50%;
        top: 40%;
        transform: translate(-50%, -50%); */
        margin: 0 auto;
        text-align: center;
        overflow: hidden;
    }
</style>
