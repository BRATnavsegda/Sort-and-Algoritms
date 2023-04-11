import random


def rand_array(array_len):
    array = []
    for i in range(0, array_len):
        array.append(random.randint(0, 100))
    return array


def heap_sort(array):
    def sift_down(parent, limit):
        item = array[parent]
        while True:
            child = (parent * 2) + 1
            if child >= limit:
                break
            if child + 1 < limit and array[child] < array[child + 1]:  # !
                child += 1
            if item < array[child]:  # !
                array[parent] = array[child]
                parent = child
            else:
                break
        array[parent] = item

    # Тело функции heap_sort
    length = len(array)
    # Формирование первичной пирамиды
    for index in range((length // 2) - 1, -1, -1):
        sift_down(index, length)
    # Окончательное упорядочение
    for index in range(length - 1, 0, -1):
        array[0], array[index] = array[index], array[0]
        sift_down(0, index)


my_array = rand_array(10)

print("Исходная последовательность:")
print(my_array)

heap_sort(my_array)

print("Упорядоченная последовательность:")
print(my_array)



