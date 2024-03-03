def solution(record):
    answer = []
    user_list = {}

    for rec in record:
        v = rec.split()

        if v[0] in ['Enter', 'Change']:
            user_list[v[1]] = v[2]

    for rec in record:
        v = rec.split()
        if v[0] == 'Enter':
            answer.append(f'{user_list[v[1]]}님이 들어왔습니다.')
        elif v[0] == 'Leave':
            answer.append(f'{user_list[v[1]]}님이 나갔습니다.')

    return answer

record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]
solution(record)