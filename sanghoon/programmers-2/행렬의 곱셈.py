import numpy as np


def solution(arr1, arr2):
    list1 = np.array(arr1)
    list2 = np.array(arr2)

    return np.dot(list1, list2).tolist()