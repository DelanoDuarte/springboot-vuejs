<template>
    <div class="funcionariosave">

        <div class="col-md-12 animated fadeIn">

            <div align="center">
                <div class="col-md-12" align="center">
                    <div>
                        <h3 class="display-4">Novo Funcionario</h3>
                        <p class="lead">Cadastro de novo Funcionario no sistema.</p>
                        <hr class="my-1">
                    </div>
                </div>
            </div>

            <div class="row">

                <div class="col-md-8">
                    <fieldset>
                        <legend>Dados Funcionário</legend>

                        <div class="row">

                            <div class="form-group col-md-8">
                                <label for="nomeFuncionario">Nome do Funcionário</label>
                                <input type="text" class="form-control col-md-8" required id="nomeFuncionario" v-model="funcionario.nomeFuncionario" placeholder="Digite O Nome do Funcionário !">
                            </div>

                            <div class="form-group col-md-4">
                                <label for="cargoFuncionario">Cargo</label>
                                <select class="form-control col-md-6" id="cargoFuncionario" v-model="funcionario.funcionarioCargo">
                                    <option selected>Selecione</option>
                                    <option v-for="cargo in cargos" v-bind:key="cargo.cargoId" v-bind:value="cargo">{{cargo.dscCargo}}</option>
                                </select>
                            </div>

                        </div>

                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="salarioFuncionario">Salário</label>
                                <input type="text" v-mask="'####.##'" class="form-control col-md-4" required id="salarioFuncionario" v-model="funcionario.salarioFuncionario" placeholder="Digite O Salário do Funcionário !">
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-8">
                                <label for="dataNascimento">Data de Nascimento</label>
                                <input type="date" class="form-control col-md-4" required id="dataNascimento" v-model="funcionario.dataNascimento" placeholder="dd/MM/yyyy ">
                            </div>
                        </div>

                    </fieldset>
                </div>

                <div class="col-md-4">

                    <div v-if="funcionario.funcionarioCargo">

                        <div align="center" v-if="funcionario.funcionarioCargo.dscCargo">
                            <h4>Incidencias para o Cargo {{funcionario.funcionarioCargo.dscCargo}} </h4>
                        </div>

                        <div class="card text-white bg-success">
                            <div id="corpocard" class="card-body">
                                <img src="assets/icons/icon-dinheiro.png" /> Incidencias Salarias Aliadas para o cargo selecionado
                            </div>
                        </div>

                        <div class="list-group animated bounceInDown" v-for="ic in funcionario.funcionarioCargo.cargoIncidenciasSalario" v-bind:key="ic.idIncidenciaSalario">
                            <a href="#" class="list-group-item list-group-item-action flex-column align-items-start">
                                <div class="d-flex w-100 justify-content-between">
                                    <h5 class="mb-1">{{ic.nomeIncidenciaSalario}}</h5>
                                    <!--<small>3 days ago</small>-->
                                </div>
                                <p class="mb-1">
                                    <b>R$ </b> {{ic.valorIncidenciaSalario}} </p>
                            </a>
                        </div>
                    </div>

                </div>

            </div>

            <br />
            <fieldset class="col-md-6">
                <legend>Incidencias Saláriais do Funcionário</legend>
                <b-form-checkbox-group name="incidenciasSalariais" v-model="funcionario.funcionarioInncidenciasSalario">
                    <b-form-checkbox v-for="incidenciaSalario in incidenciasSalariais" v-bind:value="incidenciaSalario" v-bind:key="incidenciaSalario.idIncidenciaSalario">
                        <b>Nome: </b> {{incidenciaSalario.nomeIncidenciaSalario}}<br/>
                    </b-form-checkbox>
                </b-form-checkbox-group>
            </fieldset>
            <br />

            <div align="center">

                <button v-on:click="saveFuncionario" type="button" class="btn btn-primary">Salvar</button>
                <router-link class="btn btn-success" to="/funcionario/all">Voltar</router-link>

            </div>
        </div>
    </div>

    </div>
</template>

<script>
import moment from 'moment'
import { mask } from 'vue-the-mask'
export default {
    name: 'funcionariosave',
    data() {
        return {
            incidenciasSalariais: [],
            cargos: [],
            funcionario: {
                nomeFuncionario: '',
                salarioFuncionario: '',
                dataNascimento: '',
                funcionarioCargo: '',
                funcionarioInncidenciasSalario: []
            }
        }
    },

    created() {

    },

    mounted() {
        this.getCargosDisponiveis();
        this.getIncidenciasSalarias();
    },

    methods: {

        convertDate(data) {
            let dataNasc = new Date(data);
            return dataNasc;
        },

        getCargosDisponiveis() {
            fetch('http://localhost:8080/employee-management/cargo/all')
                .then(response => {
                    response.json()
                        .then(data => {
                            this.cargos = data
                        })
                        .catch(error => {
                            console.log(error);
                        })
                })
                .catch(error => {
                    console.log(error);
                })
        },

        getIncidenciasSalarias() {
            fetch('http://localhost:8080/employee-management/incidencia-salario/all')
                .then(response => {
                    response.json()
                        .then(data => {
                            this.incidenciasSalariais = data
                        })
                        .catch(error => {
                            console.log(error)
                        })
                }).catch(error => {
                    console.log(error)
                })

        },

        saveFuncionario() {

            let headers = new Headers();
            headers.append('Content-Type', 'application/json')

            // this.funcionario.dataNascimento = moment(this.funcionario.dataNascimento).format('YYYY/MM/DD')
            this.funcionario.dataNascimento = undefined;

            fetch('http://localhost:8080/employee-management/funcionario', {
                method: 'POST',
                headers: headers,
                body: JSON.stringify(this.funcionario)
            }).then(response => {
                if (response.status == 200)
                    this.$router.push({ path: '/funcionario/all' })
            }).catch(error => {
                console.log(error)
            })
        }


    }

}
</script>

<style scoped>
#corpocard {
    text-align: center;
}
</style>
