def solution(bandage, health, attacks):
    t, x, y = bandage
    max_health = health
    # 마지막 인덱스의 시간으로 종료 시간 할당
    end_time = attacks[-1][0]
    # 공격 시간에 피해량으로 dictionary로 정리
    attacks = {attack[0]: attack[1] for attack in attacks}

    cur_t = 0
    cur_health = health
    for i in range(end_time + 1):
        # 전투시작
        if i in attacks:
            cur_t = 0
            # 공격으로 health 피해
            cur_health -= attacks[i]

            # 체력 0으로 사망
            if cur_health <= 0:
                return -1
            # 공격 받을땐 붕대감기를 pass
            continue

        # dictionary에 해당 초가 없어 공격받지 않을땐 붕대감기 시작
        cur_t += 1
        cur_health += x

        # 추가 회복
        if cur_t == t:
            cur_health += y
            cur_t = 0

        cur_health = min(cur_health, max_health)

    return cur_health