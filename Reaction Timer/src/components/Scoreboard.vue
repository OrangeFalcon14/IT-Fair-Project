<template>
    <h2>Scoreboard</h2>
    <br>
    <table>
        <tr>
            <th>Name</th>
            <th>Rank</th>
            <th>Reaction Time</th>
        </tr>
        <tr v-for="user in users" :key="user.id">
            <td>{{ user.name }}</td>
            <td>{{ user.rank }}</td>
            <td>{{ user.reactionTime }}</td>
        </tr>
    </table>
</template>

<script>
export default {
    data(){
        return{
            users: []
        }
    },
    mounted(){
        fetch("http://localhost:3000/users")
            .then(res => res.json())
            .then(data => this.users = data)
            .catch(err => console.log(err))
    }
}
</script>

<style>
table{
    height: auto;
    width: 100%;
    background: #282828;
    padding: 10px;
    border-radius: 10px;
}
table th{
    font-weight: bold;
    font-size: 1.35rem;
}
table tr{
    font-size: 1rem;
}
</style>
