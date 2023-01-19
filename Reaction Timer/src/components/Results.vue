<template>
    <p class="reaction-time">Reaction Time is {{ score }}ms</p>
    <p class="rank">{{ rank }}</p>
    <br><br>
    <button @click="saveScores">Save</button>
</template>

<script>
export default {
    props: ["score"],
    data(){
        return{
            rank: null
        }
    },
    mounted(){
        if(this.score < 250)this.rank = "Faster than light :)";        
        else if(this.score >= 250 && this.score < 300)this.rank = "Cheetah :)";
        else if(this.score >= 300 && this.score < 350)this.rank = "Toyota Corolla :|";
        else if(this.score >= 350)this.rank = "Snail :(";
    },
    methods: {
        saveScores(){
            console.log(this.rank);
            this.$emit("modal", {
                from: "results", 
                rank: this.rank, 
                reactionTime: this.score,
            })
        }
    }
}
</script>

<style>
.rank{
    font-size: 30px;
    color: white;
}
.reaction-time{
    font-size: 1rem;
}
</style>
