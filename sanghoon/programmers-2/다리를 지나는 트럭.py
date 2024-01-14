from collections import deque
def solution(bridge_length, weight, truck_weights):
    answer = 0
    bridge_ing = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)
    total_weight = 0
    while bridge_ing :
        answer += 1
        total_weight -= bridge_ing.popleft()

        if truck_weights :
            if total_weight + truck_weights[0] <= weight:
                ing_truck = truck_weights.popleft()
                bridge_ing.append(ing_truck)
                total_weight += ing_truck
            else :
                bridge_ing.append(0)
    print(answer)
    return answer

bridge_length = 100
weight = 100
truck_weights = [10]
solution(bridge_length, weight, truck_weights)