# QUFC - Compartilhamento de Conhecimento Acadêmico

Bem-vindo ao **QUFC**! Este aplicativo tem como objetivo facilitar o compartilhamento de conhecimento entre os discentes do campus da UFC. Com o QUFC, você pode acessar resoluções de listas, simulados, materiais acadêmicos, além de interagir com outros alunos através de grupos de estudo e chats.

## 📱 Sobre o Projeto

O QUFC é um aplicativo mobile desenvolvido em **Kotlin** utilizando a arquitetura **MVVM** e serviços do **Firebase**. Ele permite que estudantes:
- Compartilhem vídeos, imagens e documentos de materiais acadêmicos.
- Criem e participem de grupos de estudo com horários e locais definidos.
- Realizem simulados para autoavaliação.
- Conversem diretamente com outros usuários por meio de um chat integrado.

## 🚀 Funcionalidades Principais

- **Autenticação de Usuário**:
  - Login/registro utilizando Firebase Authentication.
  - Recuperação de senha.

- **Publicações de Materiais**:
  - Envio de arquivos (imagens, vídeos, documentos).
  - Curtidas e comentários em publicações.

- **Simulados Acadêmicos**:
  - Criação e realização de simulados interativos.
  - Relatório de desempenho.

- **Grupos de Estudo**:
  - Criação de grupos com nome, disciplina, local, horário e organizador.
  - Participação e gerenciamento de membros.

- **Chat Integrado**:
  - Comunicação em tempo real com outros usuários.

## 🛠️ Tecnologias Utilizadas

- **Kotlin**: Linguagem de desenvolvimento para Android.
- **Firebase**:
  - **Auth**: Gerenciamento de usuários.
  - **Firestore**: Armazenamento de dados em tempo real.
  - **Storage**: Armazenamento de arquivos.
- **MVVM**: Padrão de arquitetura para separar camadas de lógica, interface e dados.
- **Jetpack Components**:
  - LiveData, ViewModel, Navigation Component, etc.

## 🌐 Estrutura do Projeto

- **View**: 
  - Activities e Fragments para UI.
  - Observação de estados do ViewModel.
  
- **ViewModel**:
  - Gestão de estados e lógica de apresentação.
  - Comunicação com o Model.
  
- **Model**:
  - Repositórios responsáveis por interagir com o Firebase.

- **Firebase**:
  - Firestore, Storage e Authentication para gerenciamento de dados e usuários.

## Equipe:
- Guilherme Pinheiro Lessa Souza
- Luis Felippe Morais de Lima
- Marcelo Mikael Pinheiro Lessa Peres
- Paulo Vitor Pinheiro da Silva
- Renan Victor de Almeida Silva

