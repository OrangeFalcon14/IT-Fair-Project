<template>
    <div class="block" v-if="showBlock" @click="stopTimer">
        Click Me!
    </div>
</template>

<script>
export default {
    props: ["delay"],
    data(){
        return{
            showBlock: false,
            timer: null,
            reactionTime: 0,  
        }
    },
    mounted(){
        setTimeout(() => {
            this.showBlock = true
            this.startTimer()
        }, this.delay)
    },
    methods: {
        startTimer(){
            this.timer = setInterval(() => {
                this.reactionTime += 10
            }, 10);
        },
        stopTimer(){
            clearInterval(this.timer)
            this.$emit("end", this.reactionTime)
        }
    }
}
</script>

<style>
.block{
    margin: 0 auto;
    width: 400px;
    /* height: 300px; */
    border-radius: 10px;
    background: rgb(0, 130, 69);
    color: white;
    text-align: center;
    padding: 100px;
}
</style>
