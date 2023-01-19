<template>
    <div class="container">
        <div class="main">
            <h1>Reaction Timer</h1>
            <br><br>
            <button @click="start" :disabled="isPlaying">Start</button>
            <br><br><br>
            <Block v-if="isPlaying" :delay="delay" @end="showResults" />

            <Results v-if="this.gameOver" :score="score" @modal="toggleModal" />
        </div>
        <div class="sidebar">
            <Scoreboard />
        </div>
        <NameModal v-if="showModal" @close="toggleModal"/>
    </div>
</template>

<script>
import Block from "./components/Block.vue"
import NameModal from './components/NameModal.vue'
import Results from "./components/Results.vue"
import Scoreboard from './components/Scoreboard.vue'

export default {
    name: "App",
    components: {Block, Results, Scoreboard, NameModal},
    data() {
        return {
            isPlaying: false,
            delay: null,
            score: null,
            gameOver: false,
            showModal: false,
            name: null,
            rank: null,
            reactionTime: null
        }
    },
    methods: {
        start() {
            this.delay = parseInt(2000 + Math.random() * 5000)
            this.isPlaying = true
            this.gameOver = false
        },
        showResults(reactionTime){
            this.score = reactionTime
            this.isPlaying = false
            this.gameOver = true
        },
        toggleModal(body){
            this.showModal = !this.showModal
            if(body){
                console.log(body);
                if(body.from == "results"){
                    this.rank = body.rank;
                    this.reactionTime = body.reactionTime;
                }else if(body.from == "modal"){
                    this.name = body.name;

                    fetch("http://localhost:3000/users", {
                        method: "POST",
                        headers: {
                            "Content-Type": "application/json"
                        },
                        body: JSON.stringify({
                            name: this.name,
                            rank: this.rank,
                            reactionTime: this.score,
                        })
                    }).then(data => console.log(data))

                }
            }
        }
    }
}
</script>

<style>
.container{
    display: grid;
    grid-template-columns: 70% auto;
}

button{
    padding: 15px;
    font-size: 1rem;
    background: rgb(0, 130, 69);
    color: white;
    border-radius: 10px;
    border: none;
    outline: none;
    transition: 0.2s;
}
button:hover{
    background: rgb(0, 167, 89);
    cursor: pointer;
}
button[disabled]{
    cursor: not-allowed;
}
h1{
    font-size: 3rem;
}
</style>
