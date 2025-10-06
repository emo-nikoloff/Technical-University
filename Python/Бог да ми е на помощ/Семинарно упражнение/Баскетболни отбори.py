"""
Има два баскетболни отбора (Team 1 и Team 2) в училище и те играят няколко мача всеки ден в зависимост от времето и интереса си.
Някой ден играят по 3 мача, някой ден по 2, някой ден по 1 и т.н. Напишете функция FindDayWinner(), която приема като аргумент името на победителя от всеки мач
и връща името на общия победител за деня. В случай на равен брой победи, върнете "Tie".
"""
def findDayWinner(winner):
    team1Wins = winner.count("Team 1")
    team2Wins = winner.count("Team 2")

    if team1Wins > team2Wins:
        return "Team 1 is winner"
    elif team2Wins > team1Wins:
        return "Team 2 is winner"
    else:
        return "Tie"

matchWinner = ["Team 1", "Team 2", "Team 1", "Team 1"]
print(findDayWinner(matchWinner))

