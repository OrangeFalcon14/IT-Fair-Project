<script>
    import Welcome from "./views/Welcome.svelte";
    import Typing from './views/Typing.svelte';
    import GKTest from "./views/GKTest.svelte";

    let views = ["welcome", "typing", "gktest", "optical_illusion", "iq_test"];
    let currentTest = 0;
    let next_test = () => {
        currentTest++;
    };
</script>

<div id="container">
    {#if currentTest == 0}
        <Welcome on:click={next_test} />
    {:else if currentTest == 1}
        <Typing on:click={next_test} />
    {:else if currentTest == 2}
        <GKTest on:click={next_test}/>
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
        overflow: auto;
    }
</style>
