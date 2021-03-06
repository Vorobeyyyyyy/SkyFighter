# UML Диаграммы
1. [Диаграмма прецедентов](#1)<br>
1.1 [Актёры](#1.1)<br>
1.2 [Варианты использования](#1.2)<br>
1.2.1 [Select level](#1.2.1)<br>
1.2.2 [Select hero](#1.2.2)<br>
1.2.3 [Play the game](#1.2.3)<br>
1.2.4 [Earn in-game currency](#1.2.4)<br>
1.2.5 [Buy additional content](#1.2.5)<br>
1.2.6 [Buy in-game currency](#1.2.6)<br>
2. [Диаграмма активности](#2)
3. [Диаграмма последовательности](#3)
4. [Диаграмма классов](#4)
5. [Диаграмма состояний](#5)
6. [Диаграмма развертывания и компонентов](#6)

### 1. Диаграмма прецедентов<a name="1"></a>
Диаграмма прецедентов представляет собой следующую диаграмму: 
![Use Case](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/Use%20cases.png)
#### 1.1 Актёры<a name="1.1"></a>
Актёр | Описание
--- | ---
Player|Пользователь, играющий в игру
Webmoney API|API для работы с сервисом оплаты WebMoney, реализующим внутриигровые покупки

#### 1.2 Варианты использования<a name="1.2"></a>
##### 1.2.1 Select level<a name="1.2.1"></a>
**Описание.** Вариант использования "Select level" позволяет пользователю выбрать карту для игры.
Поток выполнения:
1. Пользователь нажимает на кнопку "Play".
2. Пользователь выбирает нужную карту.
3. Конец.
##### 1.2.2 Select hero<a name="1.2.2"></a>
**Описание.** Вариант использования "Select hero" позволяет игрокам выбирать персонажа для игры.
Поток выполнения:
1. Пользователь нажимает на кнопку "Play".
2. Пользователь выбирает нужную карту.
3. Пользователи выбирают нужного персонажа.
4. Конец.
##### 1.2.3 Play the game<a name="1.2.3"></a>
**Описание.** Вариант использования "Play the game" позволяет пользователю играть в игру.
Поток выполнения:
1. Пользователь нажимает на кнопку "Play".
2. Пользователь выбирает нужную карту.
3. Пользователи выбирают нужного персонажа.
4. Пользователи нажимают кнопку "Ready".
5. Конец.
##### 1.2.4 Earn in-game currency<a name="1.2.4"></a>
**Описание.** Вариант использования "Earn in-game currency" позволяет пользователю зарабатывать внутриигровую валюту проводя время в игре.
Поток выполнения:
1. Пользователь совершает полезные действия внутри игры (передвижение, стрельба из оружия, убийства противников).
2. Конец.
##### 1.2.5 Buy additional content<a name="1.2.5"></a>
**Описание.** Вариант использования "Buy additional content" позволяет пользователю покупать дополнительный внутриигровой контент (Оружие, персонажи, карты).
Поток выполнения:
1. Пользователь нажимает на кнопку "Shop".
2. Пользователь выбирает нужный товар.
3. Конец.
##### 1.2.6 Buy in-game currency<a name="1.2.6"></a>
**Описание.** Вариант использования "Buy in-game currency" позволяет пользователю покупать внутриигровую валюту.
Поток выполнения:
1. Пользователь нажимает на кнопку "Shop".
2. Пользователь нажимает "+".
3. Пользователь вводит нужное колличество внутриигровой валюты.
4. Пользователь оплачивает покупку.
5. Конец.

### 2. Диаграмма активности<a name="2"></a>
Диагаммы активности более подробно расписаны в следующем документе: [диаграммы активности](https://github.com/Vorobeyyyyyy/DinoMayhem/tree/master/documentation/UML/Activity/README.md)

### 3. Диаграмма последовательности<a name="3"></a>
Диаграммы последовательности вариантов использования представляют из себя следующие диаграммы:
![Sequence Diagram](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/ActivityDiags/ActivityDiag.png)
![Sequence Diagram](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/ActivityDiags/ActivityDiag2.png)
![Sequence Diagram](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/ActivityDiags/ActivityDiag3.png)

### 4. Диаграмма классов <a name="4"></a>
Диаграмма классов доступна по [ссылке](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/ClassDiagramm/classDiag.png)

### 5. Диаграмма состояний <a name="5"></a>
Диаграммы состояний представляют собой следующие диаграммы:<br>
![State Diagram](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/State/State1.png)
![State Diagram](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/State/State2.png)

### 6. Диаграмма развертывания и компонентов <a name="6"></a>
Диаграмма развертывания и компонентов представляют собой следующую диаграммы:<br>
![Deployment-Component](https://github.com/Vorobeyyyyyy/DinoMayhem/blob/master/documentation/UML/Deployment/Depl.png)
