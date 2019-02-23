#include <assert.h>
#include <limits.h>
#include <math.h>
#include <stdbool.h>
#include <stddef.h>
#include <stdint.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *readline();
char **split_string(char *);

// Complete the diagonalDifference function below.
int diagonalDifference(int arr_rows, int arr_columns, int **arr)
{
    int sum1 = 0;
    int sum2 = 0;

    for (int x = 0; x < arr_rows; x++)
    {
        printf("%d -> Sum1 %d + %d   Sum2 %d + %d\n", x, sum1, arr[x][x], sum2,
               arr[x][arr_rows - 1 - x]);
        sum1 = sum1 + arr[x][x];
        sum2 = sum2 + arr[x][arr_rows - 1 - x];
    }
    return abs(sum1 - sum2);
}

int main()
{
    FILE *fptr = fopen(getenv("OUTPUT_PATH"), "w");

    char *n_endptr;
    char *n_str = readline();
    int n = strtol(n_str, &n_endptr, 10);

    if (n_endptr == n_str || *n_endptr != '\0')
    {
        exit(EXIT_FAILURE);
    }

    int **arr = malloc(n * sizeof(int *));

    for (int i = 0; i < n; i++)
    {
        *(arr + i) = malloc(n * (sizeof(int)));

        char **arr_item_temp = split_string(readline());

        for (int j = 0; j < n; j++)
        {
            char *arr_item_endptr;
            char *arr_item_str = *(arr_item_temp + j);
            int arr_item = strtol(arr_item_str, &arr_item_endptr, 10);

            if (arr_item_endptr == arr_item_str || *arr_item_endptr != '\0')
            {
                exit(EXIT_FAILURE);
            }

            *(*(arr + i) + j) = arr_item;
        }
    }

    int arr_rows = n;
    int arr_columns = n;

    int result = diagonalDifference(arr_rows, arr_columns, arr);

    fprintf(fptr, "%d\n", result);

    fclose(fptr);

    return 0;
}

char *readline()
{
    size_t alloc_length = 1024;
    size_t data_length = 0;
    char *data = malloc(alloc_length);

    while (true)
    {
        char *cursor = data + data_length;
        char *line = fgets(cursor, alloc_length - data_length, stdin);

        if (!line)
        {
            break;
        }

        data_length += strlen(cursor);

        if (data_length < alloc_length - 1 || data[data_length - 1] == '\n')
        {
            break;
        }

        alloc_length <<= 1;

        data = realloc(data, alloc_length);

        if (!line)
        {
            break;
        }
    }

    if (data[data_length - 1] == '\n')
    {
        data[data_length - 1] = '\0';

        data = realloc(data, data_length);
    }
    else
    {
        data = realloc(data, data_length + 1);

        data[data_length] = '\0';
    }

    return data;
}

char **split_string(char *str)
{
    char **splits = NULL;
    char *token = strtok(str, " ");

    int spaces = 0;

    while (token)
    {
        splits = realloc(splits, sizeof(char *) * ++spaces);

        if (!splits)
        {
            return splits;
        }

        splits[spaces - 1] = token;

        token = strtok(NULL, " ");
    }

    return splits;
}
