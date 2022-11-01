<div>
    <label for="name">Identify yourself:</label>
    <br /><br />
    <input type="text" name="name" id="name" />
    <br />
    <br />
    <button on:click style="margin-top: 10px">Start!</button>
</div>

<style>
    div{
        position:absolute;
        top:45%;
        left:50%;
        transform: translate(-50%, -50%);
    }
    input {
        font-size: 20px;
        background-color: #002a4a;
        border: none;
        outline: none;
        border-radius: 5px;
        padding: 10px;
        color: #eee;
    }
    label {
        font-size: 20px;
    }
</style>
