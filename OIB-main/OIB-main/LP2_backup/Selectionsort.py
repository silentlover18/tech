def Selectionsort(arr):
    # Iterate through the array from the beginning to the end
    for i in range(len(arr)):
        min = i  # Assume the current element is the minimum

        # Iterate through the unsorted part of the array to find the actual minimum
        for j in range(i + 1, len(arr)):
            if arr[j] < arr[min]:
                min = j

        # Swap the minimum element with the first element of the unsorted part
        (arr[i], arr[min]) = (arr[min], arr[i])

# Main program
arr = []
n = int(input("Enter the number of elements in the array: "))

print("Enter the elements in the array:")
for i in range(0, n):
    l = int(input())
    arr.append(l)

Selectionsort(arr)
print("The array after sorting is:")
print(arr)